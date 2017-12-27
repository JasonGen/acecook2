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

import javax.validation.Valid;


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
    public String home(Model model, @PathVariable("idProduct") Integer id) {
        materielModel = materielDAO.find(id);
        if (materielModel != null) {
            model.addAttribute("materiel", materielModel);
        } else {
            /**
             * <b>Article non trouvé</b>
             * <h1>Raisons possible : </h1>
             * <ul>
             *     <li>Encodage de l'url avec un id inexistant</li>
             *     <li>Problème dans la DB</li>
             * </ul>
             */
        }
        return "integrated:details";
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public String addToCart(Model model
            , @ModelAttribute(value = "basket") Basket basket
            , @Valid @ModelAttribute(value = "ligneCommande") LigneCommandeModel ligneCommandeModel, final BindingResult errors) {

        /**
         * Normalement, le calcul de stock restant doit se trouver dans une couche business absoulement ! La prof te cassera les couilles pour ça
         * DE plus, tu peux faire ton test d'intégration sur cette méthode business
         * Pour bien faire, tu devrai créer une classe (ValidationServiceBusiness), l'annotée @Service, @Transactionnal
         * et faire ce qui est présent ci-dessous
         */
        if (!errors.hasErrors()) {
            Integer stock = materielModel.getQuantiteStock();
            Integer stockRestant = stock - ligneCommandeModel.getNombrePieces();
            //On vérifie qu'on à encore du stock après la commande de N pièces
            if (stockRestant >= 0) {
                ligneCommandeModel.setMateriel(materielModel);
                ligneCommandeModel.setPrixReel(materielModel.getPrix());
                Integer idProduct = ligneCommandeModel.getMateriel().getIdMateriel();
                //Si on à déjà un article avec cet id, on lui rajoute la quantité choisie
                if (basket.getProducts().containsKey(idProduct)) {
                    //Quantité qui se trouve déjà dans la ligne de commande
                    Integer quantiteDejaPresente = basket.getProducts().get(idProduct).getNombrePieces();
                    //Quantité que l'on a choisie dans la JSP
                    Integer quantity = ligneCommandeModel.getNombrePieces() + quantiteDejaPresente;
                    basket.getProducts().get(idProduct).setNombrePieces(quantity);
                } else {
                    basket.getProducts().put(idProduct, ligneCommandeModel);
                }
                //MAJ de la quantité de stock restante pour cet article
                materielModel.setQuantiteStock(stockRestant);
                model.addAttribute("materiel", materielModel);
            } else {
                //Stock insuffisant, on péviens le user via une erreur
                System.out.println("Stock insuffisant");
                errors.rejectValue("ligneCommande.materiel.quantiteStock", "stock.insuffisant");
            }
        }
        return "integrated:details";
    }
}
