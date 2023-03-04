package sn.mouhamadou.mouhamadou.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sn.mouhamadou.mouhamadou.Dto.CandidatDto;
import sn.mouhamadou.mouhamadou.Dto.LoginDto;
import sn.mouhamadou.mouhamadou.Dto.SignUpDto;
import sn.mouhamadou.mouhamadou.Entities.Role;
import sn.mouhamadou.mouhamadou.Entities.User;
import sn.mouhamadou.mouhamadou.Repository.RoleRepository;
import sn.mouhamadou.mouhamadou.Repository.UserRepository;
import sn.mouhamadou.mouhamadou.Service.UserDetailsService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class CandidatController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsService service;

    @Autowired
    private RoleRepository roleRepository;

    //private CandidatService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

   /* @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody SignUpDto sign){
        LoginResponse loginMessage =  service.loginCandidat(sign);
        return ResponseEntity.ok(loginMessage);
    }*/

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){


        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("L'email existe déja!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.getUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("Compte crée avec succes", HttpStatus.OK);

    }
    @PostMapping("/signincandidat")
    public ResponseEntity<String> authenticateUserCandidat(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Connexion reussie!.", HttpStatus.OK);
    }
    @PostMapping("/signupcandidat")
    public ResponseEntity<?> registerUser(@RequestBody CandidatDto signUpDto){


        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("L'email existe déja!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setUsername(signUpDto.getPrenom());
        user.setNom(signUpDto.getNom());
        user.setAge(signUpDto.getAge());
        user.setAdresse(signUpDto.getAdresse());
        user.setTelephone(signUpDto.getTelephone());
        user.setSpecialite(signUpDto.getSpecialite());
        user.setNiveauEtude(signUpDto.getNiveauEtude());
        user.setExperiences(signUpDto.getExperiences());

        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName("CANDIDAT").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("Compte crée avec succes", HttpStatus.OK);

    }
    @PutMapping("/candidat/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody CandidatDto signUpDto, @PathVariable long id) {


        Optional<User> user= userRepository.findById(id);
        if (user.isEmpty())
            return ResponseEntity.notFound().build();
        User user1 = new User();
        signUpDto.getEmail();
        signUpDto.getNom();
        signUpDto.getAge();
       signUpDto.getAdresse();
        signUpDto.getTelephone();
       signUpDto.getSpecialite();
        signUpDto.getNiveauEtude();
        signUpDto.getExperiences();
;
        passwordEncoder.encode(signUpDto.getPassword());
        userRepository.save(user1);

        return new ResponseEntity<>("info modifier avec succes", HttpStatus.OK);

    }
    @GetMapping("/signup/getall")
    public List<User> list() {
        return service.listAll();
    }


}
