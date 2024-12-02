package me.dawey.springdance.controllers;

import me.dawey.springdance.models.Feedback;
import me.dawey.springdance.models.User;
import me.dawey.springdance.services.CustomUserDetailsService;
import me.dawey.springdance.services.FeedbackService;
import me.dawey.springdance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private UserService userService;

    @GetMapping("/feedback")
    public String showFeedbackPage() {
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam("message") String message,
            Model model
    ) {
        // Validate email if not authenticated
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication.getPrincipal() instanceof UserDetails)) {
            // Email validation
            if (email == null || email.trim().isEmpty()) {
                model.addAttribute("errorMessage", "Az email cím megadása kötelező!");
                return "feedback";
            }

            // Simple email regex validation
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (!Pattern.matches(emailRegex, email)) {
                model.addAttribute("errorMessage", "Érvénytelen email formátum!");
                return "feedback";
            }
        }

        // Validate message
        if (message == null || message.trim().isEmpty()) {
            model.addAttribute("errorMessage", "Az üzenet nem lehet üres!");
            return "feedback";
        }

        // Limit message length (optional)
        if (message.length() > 1000) {
            model.addAttribute("errorMessage", "Az üzenet túl hosszú (max 1000 karakter)!");
            return "feedback";
        }



        // Create feedback object
        Feedback feedback = new Feedback();

        // Set email
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.findByName(userDetails.getUsername());
            feedback.setEmail(user.getEmail());
        } else {
            if (userService.existsByEmail(email)) {
                model.addAttribute("errorMessage", "Az email cím már regisztrálva van!");
                return "feedback";
            }
            feedback.setEmail(email);
        }

        feedback.setMessage(message);
        feedback.setDate(new Date());

        // Save feedback
        feedbackService.save(feedback);

        // Redirect with success parameter
        return "redirect:/feedback?success";
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/feedback-admin")
    public String getFeedbackAdmin(Model model) {
        List<Feedback> feedbacks = feedbackService.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-admin";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/feedback-admin/delete/{id}")
    public String deleteFeedback(
            @PathVariable int id,
            RedirectAttributes redirectAttributes
    ) {
        try {
            // Check if feedback exists before deleting
            if (feedbackService.findById(id) != null) {
                feedbackService.delete(id);
                redirectAttributes.addFlashAttribute("successMessage", "Visszajelzés sikeresen törölve.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Nem létező visszajelzés.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Hiba történt a törlés során.");
        }
        return "redirect:/feedback-admin";
    }
}