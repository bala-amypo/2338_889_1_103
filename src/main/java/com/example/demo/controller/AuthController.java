@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication Endpoints")
public class AuthController {

    @PostMapping("/register")
    public String register() {
        return "User registered";
    }

    @PostMapping("/login")
    public String login() {
        return "User logged in";
    }
}