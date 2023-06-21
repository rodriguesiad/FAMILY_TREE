package laboratorio;

public class Laboratorio {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Marcos", "123");
        Pessoa pai = new Pessoa("Rogerio", "234");
        Pessoa mae = new Pessoa("Livia", "345");
        Pessoa avomaterno = new Pessoa("Jose", "456");
        Pessoa avamaterno = new Pessoa("Maria", "567");

        FamilyTree<Pessoa> arvore = new FamilyTree<>(pessoa);

        arvore.addPerson(pessoa, pai, Kinship.FATHER);
        arvore.addPerson(pessoa, mae, Kinship.MOTHER);
        arvore.addPerson(mae, avomaterno, Kinship.FATHER);
        arvore.addPerson(mae, avamaterno ,Kinship.MOTHER);

        arvore.printTreeVisual();
        arvore.calculateDegreeOfKinship(pessoa, avamaterno);

    }

}
