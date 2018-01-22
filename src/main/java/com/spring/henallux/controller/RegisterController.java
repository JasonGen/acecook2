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

import java.util.Locale;

import static com.spring.henallux.controller.Constants.ConstantsController.*;
import static com.spring.henallux.controller.MyAccountController.BASKET;


@Controller
@RequestMapping(value = "/register")
@SessionAttributes({MyAccountController.CURRENT_USER, BASKET})
public class RegisterController {

    @ModelAttribute(value = "userForm")
    public ClientModel getUserForm() {
        return new ClientModel();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return REGISTER;
    }

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private CryptingPassword cryptingPassword;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser( @ModelAttribute(value = "userForm") @Valid ClientModel clientModel, final BindingResult errors, Locale locale) {
        int error = 0;
        if (!errors.hasErrors()) {
            if (clientDAO.isEmailExist(clientModel.getEmail())) {
                errors.rejectValue("email", "alreadyExist.email");
                ++error;
                return REGISTER;
            }
            if (!clientModel.getMotDePasse().equals(clientModel.getConfirmationMotDePasse())) {
                errors.rejectValue("motDePasse", "notmatch.password");
                ++error;
                return REGISTER;
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
            return REGISTER;
        }
        return REDIRECT_HOME;
    }


}
