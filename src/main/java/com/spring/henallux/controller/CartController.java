package com.spring.henallux.controller;

import com.spring.henallux.dataAccess.DAO.AchatDAO;
import com.spring.henallux.dataAccess.DAO.LigneCommandeDAO;
import com.spring.henallux.dataAccess.DAO.MaterielDAO;
import com.spring.henallux.dataAccess.Entity.AchatEntity;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.AchatModel;
import com.spring.henallux.model.Basket;
import com.spring.henallux.model.ClientModel;
import com.spring.henallux.model.LigneCommandeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.Date;
import java.util.stream.Collectors;

import static com.spring.henallux.controller.Constants.ConstantsController.*;
import static com.spring.henallux.controller.MyAccountController.BASKET;
import static com.spring.henallux.controller.MyAccountController.CURRENT_USER;


@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({CURRENT_USER, BASKET})
public class CartController {

    @Autowired
    private AchatDAO achatDAO;
    @Autowired
    private MaterielDAO materielDAO;
    @Autowired
    private ProviderConverter providerConverter;


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:cart";
    }

    @RequestMapping(value = "/confirmOrder", method = RequestMethod.GET)
    public String getConfirmOrder(@ModelAttribute(value = BASKET) Basket basket
            , @ModelAttribute(value = CURRENT_USER) ClientModel clientModel) {
        if (clientModel.getEmail() == null) {
            return REDIRECT_MYACCOUNT;
        } else {
            AchatModel achatModel = new AchatModel();
            achatModel.setClient(clientModel);
            achatModel.setDateAchat(new Date());

            achatModel.setLigneCommandeModelList(basket.getProducts().values());
//TODO : Régler la maj des stocks ici
            basket.getProducts().entrySet().forEach(v -> {

                materielDAO.updateStock(providerConverter.materielModelToEntity(v.getValue().getMateriel()));
            });
            achatDAO.save(achatModel);
            basket.getProducts().clear();
            return REDIRECT_HOME;
        }
    }

    @RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.GET)
    public String deleteArticle(Model model, @PathVariable("id") Integer idArticle, @ModelAttribute(value = BASKET) Basket basket) {

        basket.getProducts().remove(idArticle);
        return "redirect:/cart";
    }
}
