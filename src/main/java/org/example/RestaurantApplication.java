package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

   @EnableJpaAuditing
    @SpringBootApplication
   public class RestaurantApplication {
        public static void main(String[] args) {
            SpringApplication.run(RestaurantApplication.class, args);
        }






















//    @Autowired
//    BranchRepository branchRepository;
//
//    @Autowired
//    MenuRepository menuRepository;

//    @Override
//    public void run(String... args) {
//
////        if (branchRepository.findById(1).isEmpty()) {
//            branchRepository.save(new Branch(1, "some_branch_1", "chennai_1", "872368"));
//            branchRepository.save(new Branch(2, "some_branch_2", "chennai_2", "872368"));
//            branchRepository.save(new Branch(3, "some_branch_3", "chennai_3", "898909"));
//
//            menuRepository.save(new Menu(1, "food_1", "220", "1", "some_desc", new Branch(1)));
//            menuRepository.save(new Menu(2, "food_2", "320", "1", "some_desc", new Branch(2)));
//            menuRepository.save(new Menu(1, "food_3", "220", "1", "some_desc", new Branch(1)));
//        }

}
