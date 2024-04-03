package ticketpurchase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ticketpurchase.entity.User;
import ticketpurchase.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketPurchaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/purchase_ticket")
    public User purchaseTicket(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/receipt")
    public List<User> getAllPurchases() {
        return userService.getAllUserDetails();
    }

    @GetMapping("/receipt/{id}")
    public User getReceipt(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/{section}")
    public List<User> getUsersBySection(@PathVariable String section) {
        return userService.getUserBySection(section);
    }

    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public User modifyUserSeat(@PathVariable Long id, @RequestParam("seatAllocation") String seatAllocation) {
        User userDetails = userService.getUserById(id);
        if (userDetails != null) {
            userDetails.setSeatAllocation(seatAllocation);
            return userService.saveUser(userDetails);
        }
        return null;
    }

}
