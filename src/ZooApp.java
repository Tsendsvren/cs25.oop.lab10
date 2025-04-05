import java.util.ArrayList;
import java.util.List;

public class ZooApp {
	public static void main(String[] args) {
		List<Mammal> mammals = new ArrayList<>();
		mammals.add(new Mammal("Arslan"));

		List<Animal> animals = new ArrayList<>();
		List<Bird> birds = new ArrayList<>();
		birds.add(new Bird("Togoruu"));

		Zoo<Mammal> mammalZoo = new Zoo<>();
		mammalZoo.transferAnimals(mammals, animals);
		Zoo<Bird> birdZoo = new Zoo<>();
		birdZoo.transferAnimals(birds, animals); 

		for (Animal animal : animals) {
			System.out.println(animal.getName());
		}
	}
}
