package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        // Check if the database is empty before adding sample data
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // Add sample parts
            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setName("CPU");
            cpu.setInv(50);
            cpu.setPrice(200.0);
            cpu.setMinInv(5);
            cpu.setMaxInv(100);
            partRepository.save(cpu);

            OutsourcedPart motherboard = new OutsourcedPart();
            motherboard.setName("Motherboard");
            motherboard.setInv(40);
            motherboard.setPrice(150.0);
            motherboard.setMinInv(5);
            motherboard.setMaxInv(80);
            partRepository.save(motherboard);

            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setName("GPU");
            gpu.setInv(60);
            gpu.setPrice(300.0);
            gpu.setMinInv(5);
            gpu.setMaxInv(120);
            partRepository.save(gpu);

            OutsourcedPart ram = new OutsourcedPart();
            ram.setName("RAM");
            ram.setInv(100);
            ram.setPrice(80.0);
            ram.setMinInv(10);
            ram.setMaxInv(200);
            partRepository.save(ram);

            OutsourcedPart storage = new OutsourcedPart();
            storage.setName("Storage");
            storage.setInv(80);
            storage.setPrice(100.0);
            storage.setMinInv(10);
            storage.setMaxInv(150);
            partRepository.save(storage);

            // Add sample products (pre-built PCs)
            Product gamingPC = new Product("Gaming PC", 1500.0, 10);
            productRepository.save(gamingPC);

            Product workstationPC = new Product("Workstation PC", 2000.0, 8);
            productRepository.save(workstationPC);

            Product homePC = new Product("Home PC", 1000.0, 15);
            productRepository.save(homePC);

            Product officePC = new Product("Office PC", 1200.0, 12);
            productRepository.save(officePC);

            Product multimediaPC = new Product("Multimedia PC", 1800.0, 6);
            productRepository.save(multimediaPC);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
