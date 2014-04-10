public class Color {
  float Red, Green, Blue;

  Color() { }

  Color(float Red, float Green, float Blue) {
    set(Red, Green, Blue);
  }
  
  void set(float Red, float Green, float Blue){
    this.Red = Red;
    this.Green = Green;
    this.Blue = Blue;
  }
}

