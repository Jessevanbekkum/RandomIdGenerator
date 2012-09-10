package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import randomidprovider.Person;
import randomidprovider.PersonGenerator;

/**
 * Basic controller
 *
 */
@Controller
public class RandomIdController {

    @Autowired
    @Qualifier(value = "personGeneratorImpl")
    private PersonGenerator personGenerator ;

    //

    public RandomIdController() {
    }
//
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getCart() {

        return personGenerator.getPerson();

    }
//
//    @RequestMapping(value = "/cart/addtocart/{item}", method = RequestMethod.GET)
//    public ModelAndView addToCart(@PathVariable final String item) {
//
//        cartService.addToCart(item);
//        return getCart();
//
//    }
//
//    @RequestMapping(value = "/cart/removefromcart/{item}", method = RequestMethod.GET)
//    public ModelAndView removeFromCart(@PathVariable final String item) {
//
//        cartService.removeFromCart(item);
//        return getCart();

//    }


}