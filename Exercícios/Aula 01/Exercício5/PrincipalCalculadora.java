public class PrincipalCalculadora {

    public static void main(String[] args) {

        ICalculadora calculadora = new Calculadora();

        double soma = calculadora.somar(10, 5);
        double subtracao = calculadora.subtrair(10, 5);
        double multiplicacao = calculadora.multiplicar(10, 5);
        double divisao = calculadora.dividir(10, 5);
        double raiz = calculadora.raizQuadrada(25, 16);
        double potencia = calculadora.elevarPotencia(2, 3);
        double logaritmo = calculadora.logaritmo10(100);

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        System.out.println("Divisão: " + divisao);
        System.out.println("Raiz quadrada: " + raiz);
        System.out.println("Potência: " + potencia);
        System.out.println("Logaritmo na base 10: " + logaritmo);
    }
}