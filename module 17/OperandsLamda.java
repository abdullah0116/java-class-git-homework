public class OperandsLamda {
  public static void main(String[] args) {
    Operands op = new Operands(8,8);
    op.executBinaryOperation("multiplication", (double left, double right) -> {return left * right;});
    op.executBinaryOperation("addition", (double left, double right) -> {return left + right;});
  }
}
