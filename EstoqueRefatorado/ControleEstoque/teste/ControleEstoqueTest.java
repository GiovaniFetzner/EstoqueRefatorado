package teste;

import classes.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControleEstoqueTest {
    private static final String TEST_FILE_PATH = "teste/ItensTest.csv";
    ControleEstoque estoque = new ControleEstoque();
    ArrayList<Item> itens;

    public ControleEstoqueTest() {
        itens = new ArrayList<>();
        itens = estoque.leituraCSV(TEST_FILE_PATH);
    }

    @Test
    void testVerificaCodigo01() { //Cenario: Item existente no estoque
        assertTrue(estoque.vericaCodigo(3434) != null);
    }

    @Test
    void testVerificaCodigo02() { //Cenario: Item existente no estoque
        assertFalse(estoque.vericaCodigo(5151) != null);
    }

    @Test
    void testRemoveItem01() { // Cenario: Adicionando item e removendo
        estoque.addItem(new Item(8989,Categoria.BONE,
                "Bone teste", 90.00, 10, 5));
        assertTrue(estoque.vericaCodigo(8989) != null);
        System.out.println(estoque.vericaCodigo(8989).toString());
        estoque.removeItem(8989);
        assertTrue(estoque.vericaCodigo(8989) == null);
    }

    @Test
    void testRemoveItem02() { // Cenario: Tentando remover item sem estar no estoque
        assertTrue(estoque.vericaCodigo(5555) == null);
        assertFalse(estoque.removeItem(5555));
    }
    @Test
    void testAddItem() { // Cenario: Adicionando item no estoque
        Item item  = new Item(8989,Categoria.BONE,
                "Bone teste", 90.00, 10, 5);
        estoque.addItem(item);
        assertNotNull(estoque.vericaCodigo(8989));
        assertTrue(estoque.vericaCodigo(8989) != null);
    }
    @Test
    void modificaItem01() { // Cenario: Adicionando item no estoque e aumentando
        Item item  = new Item(8989,Categoria.BONE,
                "Bone teste", 90.00, 10, 5);
        estoque.addItem(item);
        assertNotNull(estoque.vericaCodigo(8989));
        assertTrue(estoque.vericaCodigo(8989) != null);
        assertEquals(10,estoque.vericaCodigo(8989).getQuantidade());
        System.out.println(estoque.vericaCodigo(8989).toString());
        estoque.modificarItem(8989,50); // Adiciona 50 ao item
        System.out.println(estoque.vericaCodigo(8989).toString());
        assertEquals(60,estoque.vericaCodigo(8989).getQuantidade());

    }
    @Test
    void modificaItem02() { // Cenario: Adicionando item no estoque e reduzindo
        Item item  = new Item(8989,Categoria.BONE,
                "Bone teste", 90.00, 10, 5);
        estoque.addItem(item);
        assertNotNull(estoque.vericaCodigo(8989));
        assertTrue(estoque.vericaCodigo(8989) != null);
        assertEquals(10,estoque.vericaCodigo(8989).getQuantidade());
        System.out.println(estoque.vericaCodigo(8989).toString());
        estoque.modificarItem(8989,-50); // Retira 50 ao item
        System.out.println(estoque.vericaCodigo(8989).toString());
        assertEquals(0,estoque.vericaCodigo(8989).getQuantidade());

    }



}