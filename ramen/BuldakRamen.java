package ch10_extends_interface.ramen;

public class BuldakRamen extends Ramen{
	
	public BuldakRamen() {
		super("불닭볶음면",1500,"닭그림.jpg");
	}

	@Override
	public void printRecipe() {
	System.out.println("끓는 물에 면을 삶은 후 건져서 액상스프에 비벼 드세요");
	}
	
	
	
	
	
	
}
