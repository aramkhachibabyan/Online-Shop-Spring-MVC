package com.smartCode.springMvc.controller;

import com.smartCode.springMvc.service.user.UserService;
import com.smartCode.springMvc.util.constants.Keyword;
import com.smartCode.springMvc.util.constants.Path;
import com.smartCode.springMvc.util.encoder.AESManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView start(HttpSession session,
                              @CookieValue(name = Keyword.REMEMBER,required = false) Cookie cookie1,
                              HttpServletResponse httpServletResponse) {

        try {
            if (cookie1 != null) {
                String encodedString = cookie1.getValue();
                String remember = AESManager.decrypt(encodedString);
                String email = remember.split(":")[0];
                String password = remember.split(":")[1];
                return login(email, password, remember, httpServletResponse, session);
            } else {
                return new ModelAndView(Path.LOGIN);
            }
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(Path.LOGIN);
            modelAndView.addObject(Keyword.MESSAGE, e.getMessage());
            return modelAndView;
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String email,
                              @RequestParam String password,
                              @RequestParam(required = false) String rememberMe,
                              HttpServletResponse httpServletResponse,
                              HttpSession session) {
        try {
            userService.login(email, password);
            if (rememberMe != null) {
                Cookie cookie = new Cookie(Keyword.REMEMBER, AESManager.encrypt(email + ":" + password));
                cookie.setMaxAge(360000);
                httpServletResponse.addCookie(cookie);
            }
            session.setAttribute(Keyword.EMAIL, email);
            return new ModelAndView(Path.HOME_PAGE);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(Path.LOGIN);
            modelAndView.addObject(Keyword.MESSAGE, e.getMessage());
            return modelAndView;
        }

    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam String name,
                                 @RequestParam String lastname,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String age,
                                 HttpSession session) {
        int age1 = 0;
        try {
            age1 = Integer.parseInt(age);
        } catch (Exception ignored) {
        }
        try {
            userService.register(name, lastname, email, password, age1);
            session.setAttribute(Keyword.EMAIL, email);
            return new ModelAndView(Path.HOME_PAGE);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(Path.REGISTER);
            modelAndView.addObject(Keyword.MESSAGE, e.getMessage());
            return modelAndView;
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(@CookieValue(name = Keyword.REMEMBER,required = false) Cookie cookie,
                         HttpServletResponse httpServletResponse,
                         HttpSession session) {
        if (cookie != null) {
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
        }
        session.invalidate();
        return Path.LOGIN;
    }

    @RequestMapping(path = "/deleteAccount", method = RequestMethod.POST)

    public ModelAndView deleteAccount(HttpSession session,
                                      @RequestParam String password,
                                      @CookieValue(name = Keyword.REMEMBER,required = false) Cookie cookie,
                                      HttpServletResponse httpServletResponse,
                                      @SessionAttribute(Keyword.EMAIL) String email) {
        try {
            userService.deleteUser(email, password);
            if (cookie != null) {
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
            }
            session.invalidate();
            return new ModelAndView(Path.LOGIN);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(Path.DELETE_ACCOUNT);
            modelAndView.addObject(Keyword.MESSAGE, e.getMessage());
            return modelAndView;
        }
    }

    @RequestMapping(path = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePassword(HttpSession session,
                                       @RequestParam String newPassword,
                                       @RequestParam String repeatPassword,
                                       @SessionAttribute(Keyword.EMAIL) String email) {
        try {
            userService.updateUser(email, newPassword, repeatPassword);
            return new ModelAndView(Path.HOME_PAGE);
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(Path.CHANGE_PASSWORD);
            modelAndView.addObject(Keyword.MESSAGE, e.getMessage());
            return modelAndView;
        }
    }

}





