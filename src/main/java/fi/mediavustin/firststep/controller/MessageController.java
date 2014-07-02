package fi.mediavustin.firststep.controller;



        import java.util.HashMap;
        import java.util.Map;

        import javax.validation.Valid;

        import fi.mediavustin.firststep.domain.Message;
        import fi.mediavustin.firststep.service.MessageService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.validation.BindingResult;
        import org.springframework.validation.FieldError;
        import org.springframework.validation.ObjectError;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class MessageController {


    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    //@Autowired
    //public MessageController(messageService messageService) {
    //    this.messageService = messageService;
    //}

    @RequestMapping
    public ModelAndView list() {

        log.info("**** 1 ****");

        Iterable<Message> messages = this.messageService.findAll();
        return new ModelAndView("messages/list", "messages", messages);
    }

    @RequestMapping("{id}")
    public ModelAndView view(@PathVariable("id") Message message) {
        log.info("**** 2 ****");
        return new ModelAndView("messages/view", "message", message);
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute Message message) {
        log.info("**** 3 ****");
        return "messages/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@Valid Message message, BindingResult result,
                               RedirectAttributes redirect) {
        log.info("**** 4 ****");
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView("messages/form");
            mav.addObject("formErrors", result.getAllErrors());
            mav.addObject("fieldErrors", getFieldErrors(result));
            return mav;
        }
        message = this.messageService.save(message);
        redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
        return new ModelAndView("redirect:/{message.id}", "message.id", message.getId());
    }

    private Map<String, ObjectError> getFieldErrors(BindingResult result) {
        log.info("**** 5 ****");
        Map<String, ObjectError> map = new HashMap<String, ObjectError>();
        for (FieldError error : result.getFieldErrors()) {
            map.put(error.getField(), error);
        }
        return map;
    }

    @RequestMapping("foo")
    public String foo() {
        log.info("**** foo ****");
        throw new RuntimeException("Expected exception in controller");
    }

}