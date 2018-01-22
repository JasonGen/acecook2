package com.spring.henallux.controller;

import com.spring.henallux.dataAccess.DAO.MaterielDAO;
import com.spring.henallux.model.Basket;
import com.spring.henallux.model.LigneCommandeModel;
import com.spring.henallux.model.MaterielModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import javax.validation.Valid;

import static com.spring.henallux.controller.Constants.ConstantsController.DETAILS;


@Controller
@RequestMapping(value = "/details")
@SessionAttributes({MyAccountController.CURRENT_USER, MyAccountController.BASKET})
public class DetailsController {

    @Autowired
    private MaterielDAO materielDAO;

    private MaterielModel materielModel;

    @ModelAttribute(value = "ligneCommande")
    public LigneCommandeModel ligneCommandeModel() {
        return new LigneCommandeModel();
    }

    @RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
    public String home(ModelMap model, @PathVariable("idProduct") Integer id, @ModelAttribute(value = "basket") Basket basket
            , @Valid @ModelAttribute(value = "ligneCommande") LigneCommandeModel ligneCommandeModel) {
        materielModel = materielDAO.find(id);
        if (materielModel != null) {
            model.addAttribute("materiel", materielModel);

            if(ligneCommandeModel.getNombrePieces() != null) {
                Integer stock = materielModel.getQuantiteStock();
                Integer stockRestant = stock - ligneCommandeModel.getNombrePieces();
                materielModel.setQuantiteStock(stockRestant);
                model.addAttribute("materiel", materielModel);
            }
        }
        return DETAILS;
    }
//TODO : envoyer le stock restant dans la jsp en prenant la donnée dans basket.
    //besket key 1, lignecommande id = null though
    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public String addToCart(Model model
            , @ModelAttribute(value = "basket") Basket basket
            , @Valid @ModelAttribute(value = "ligneCommande") LigneCommandeModel ligneCommandeModel,  final BindingResult errors) {
        if (!errors.hasErrors()) {
            Integer stock = materielModel.getQuantiteStock();
            Integer stockRestant = stock - ligneCommandeModel.getNombrePieces();
            if (stockRestant >= 0) {
                ligneCommandeModel.setMateriel(materielModel);
                ligneCommandeModel.setPrixReel(materielModel.getPrix());
                Integer idProduct = ligneCommandeModel.getMateriel().getIdMateriel();
                if (basket.getProducts().containsKey(idProduct)) {
                    Integer quantiteDejaPresente = basket.getProducts().get(idProduct).getNombrePieces();
                    Integer quantity = ligneCommandeModel.getNombrePieces() + quantiteDejaPresente;
                    basket.getProducts().get(idProduct).setNombrePieces(quantity);
                } else {
                    basket.getProducts().put(idProduct, ligneCommandeModel);
                }
                materielModel.setQuantiteStock(stockRestant);
                model.addAttribute("materiel", materielModel);
            } else {
                System.out.println("GROS CACA ICI");
                errors.rejectValue("ligneCommande.materiel.quantiteStock", "stock.insuffisant");
            }
        }
        return DETAILS;
    }
}
