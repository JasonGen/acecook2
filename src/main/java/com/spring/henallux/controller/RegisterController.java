package com.spring.henallux.controller;

import javax.validation.Valid;

import com.spring.henallux.Service.CryptingPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.DAO.ClientDAO;
import com.spring.henallux.model.ClientModel;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.spring.henallux.controller.MyAccountController.BASKET;


@Controller
@RequestMapping(value = "/register")
@SessionAttributes({MyAccountController.CURRENT_USER, BASKET})
public class RegisterController {

    private static final String HOME = "redirect:/index";
    private static final String REGISTER_PAGE = "integrated:register";

    @ModelAttribute(value = "userForm")
    public ClientModel getUserForm() {
        return new ClientModel();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return REGISTER_PAGE;
    }

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private CryptingPassword cryptingPassword;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute(value = "userForm") ClientModel clientModel, final BindingResult errors) {
        int error = 0;
        if (!errors.hasErrors()) {
            if (clientDAO.isEmailExist(clientModel.getEmail())) {
                errors.rejectValue("emailExisting", "alreadyExist.email");
                ++error;
                return REGISTER_PAGE;
            }
            if (!clientModel.getMotDePasse().equals(clientModel.getConfirmationMotDePasse())) {
                errors.rejectValue("confirmPassword", "notmatch.password");
                ++error;
                return REGISTER_PAGE;
            }
            if (error == 0) {
                try {
                    clientModel.setMotDePasse(cryptingPassword.cryptedPassword(clientModel.getMotDePasse()));
                    clientDAO.save(clientModel);
                } catch (Exception e) {
                    System.out.println("Erreur cryptage password");
                }
            }
        } else {
            return REGISTER_PAGE;
        }
        return HOME;
    }


}
