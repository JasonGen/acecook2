package com.spring.henallux.controller;

import com.spring.henallux.Service.CryptingPassword;
import com.spring.henallux.dataAccess.DAO.ClientDAO;
import com.spring.henallux.model.Basket;
import com.spring.henallux.model.ClientModel;
import com.spring.henallux.model.LoginForm;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static com.spring.henallux.controller.Constants.ConstantsController.MYACCOUNT;
import static com.spring.henallux.controller.Constants.ConstantsController.REDIRECT_HOME;
import static com.spring.henallux.controller.MyAccountController.BASKET;
import static com.spring.henallux.controller.MyAccountController.CURRENT_USER;

@Controller
@RequestMapping(value = "/myAccount")
@SessionAttributes({CURRENT_USER, BASKET})
public class MyAccountController {

    public static final String CURRENT_USER = "currentUser";
    public static final String BASKET = "basket";

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private CryptingPassword cryptingPassword;

    @ModelAttribute(BASKET)
    public Basket getBasket() {
        return new Basket();
    }

    @ModelAttribute(CURRENT_USER)
    public ClientModel getCurrentClient() {
        return new ClientModel();
    }

    @ModelAttribute(value = "loginForm")
    public LoginForm getLoginForm() {
        return new LoginForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:myAccount";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute(value = "loginForm") LoginForm loginForm, @ModelAttribute(value = CURRENT_USER) ClientModel currentUser) {

        String cryptedPassword = null;

        try {
            cryptedPassword = cryptingPassword.cryptedPassword(loginForm.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentUser = clientDAO.existForEmailAndPassword(loginForm.getEmail(), cryptedPassword);
        if (currentUser == null) {
            return MYACCOUNT;
        }
        model.addAttribute(CURRENT_USER, currentUser);
        return REDIRECT_HOME;
    }

    @RequestMapping(value = "disconnect", method = RequestMethod.GET)
    public String disconnect(Model model, @ModelAttribute(value = BASKET) Basket panier, @ModelAttribute(value = CURRENT_USER) ClientModel user, SessionStatus sessionStatus) {
        panier.getProducts().clear();
        sessionStatus.setComplete();
        return REDIRECT_HOME;
    }
}
