public class Test
{
    public static void main(String[] args) {
	Section test = new Section(10, 20);
	new Frame(new SectionComponent(test));
    }
}
