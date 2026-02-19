//Ejercicio 1
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Examen extends JFrame {
    private final JTextField campoTexto; // Campo de texto para ingresar el nombre del producto
    private final JButton botonGuardar; // Botón para guardar el producto
    private final DefaultListModel<String> modeloLista; // Modelo para la lista de productos
    private final JList<String> listaProductos; // Lista para mostrar los productos registrados

    public Examen() {
        super("Registro de productos");
        setLayout(new FlowLayout());

        // Etiqueta para el nombre del producto
        JLabel etiqueta = new JLabel("Nombre del Producto:");
        add(etiqueta);

        // Campo de texto para ingresar el nombre del producto
        campoTexto = new JTextField(20);
        add(campoTexto);

        // Botón para guardar el producto
        botonGuardar = new JButton("Guardar Producto");
        add(botonGuardar);

        // Modelo para la lista de productos
        modeloLista = new DefaultListModel<>();
        listaProductos = new JList<>(modeloLista);
        listaProductos.setVisibleRowCount(5);
        listaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregar la lista dentro de un JScrollPane
        add(new JScrollPane(listaProductos));

        // Manejador de eventos para el botón "Guardar Producto"
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String producto = campoTexto.getText().trim();
                if (!producto.isEmpty()) {
                    modeloLista.addElement(producto); // Agregar el producto a la lista
                    JOptionPane.showMessageDialog(
                        Examen.this,
                        "Producto registrado: " + producto,
                        "Registro Exitoso",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    campoTexto.setText(""); // Limpiar el campo de texto
                } else {
                    JOptionPane.showMessageDialog(
                        Examen.this,
                        "El campo de texto está vacío. Por favor, ingrese un producto.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Manejador de eventos para la selección de la lista
        listaProductos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evento) {
                if (!evento.getValueIsAdjusting()) { // Evitar eventos duplicados
                    String productoSeleccionado = listaProductos.getSelectedValue();
                    if (productoSeleccionado != null) {
                        JOptionPane.showMessageDialog(
                            Examen.this,
                            "Producto seleccionado: " + productoSeleccionado,
                            "Producto Seleccionado",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            Examen ventana = new Examen();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(400, 300); // Tamaño de la ventana
            ventana.setVisible(true); // Mostrar la ventana
        });
    }
}