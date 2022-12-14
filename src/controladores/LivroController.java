package controladores;

import ferramentas.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Livro;


public class LivroController {
    
    
    public Livro buscar(int id)
    {
        try {
            Livro objLivro = null;
            
            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = "";
            wSql = " SELECT * ";
            wSql += " FROM livro ";
            wSql += " WHERE id = ? ";

            try{
                System.out.println("Vai Executar Conexão em buscar livro");
                stmt = Conexao.con.prepareStatement(wSql);
                stmt.setInt(1, id);

                rs = stmt.executeQuery();
                
                if(rs.next()){
                    objLivro = new Livro();
                    objLivro.setId(rs.getInt("id"));
                    objLivro.setTitulo(rs.getString("titulo"));
                    objLivro.setAutor(rs.getString("autor"));
                    objLivro.setGenero(rs.getString("genero"));
                    objLivro.setPaginas(rs.getInt("paginas"));
                    
                    objLivro.setId(rs.getInt("id"));
                    return objLivro;
                }
                
            }catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        return null;
		
    }
    
    public boolean verificaExistencia(Livro objLivro){
    try {
            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = " SELECT * ";
            wSql += " FROM livro ";
            wSql += " WHERE titulo = ? ";
            if(objLivro.getId() > 0){
                wSql += " AND id <> ? ";
            }

            System.out.println("Vai Executar Conexão em verificaExistencia livro");
            stmt = Conexao.con.prepareStatement(wSql);
            stmt.setString(1, objLivro.getTitulo());   
            if(objLivro.getId() > 0){
                stmt.setInt(2, objLivro.getId());   
            }

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
            return false;
        }

        return false;

    }

    
    public boolean incluir(Livro objLivro){
        
        try {
                      
            Conexao.abreConexao();
            PreparedStatement stmt = null;

            stmt = Conexao.con.prepareStatement("INSERT INTO livro (titulo, autor, genero, paginas) VALUES(?,?,?,?)");
            stmt.setString(1, objLivro.getTitulo());
            stmt.setString(2, objLivro.getAutor());            
            stmt.setString(3, objLivro.getGenero());
            stmt.setInt(4, objLivro.getPaginas());

            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(Conexao.con);
        }
        
    }
    
    public void preencherLista(JTable jtbLivros) {

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id");
        cabecalhos.add("Titulo");
        cabecalhos.add("Autor");
        
        Conexao.abreConexao();
        ResultSet result = null;
        
        try {

            String sql = "";
            sql = "SELECT id, titulo, autor";
            sql += " FROM livro ";
            sql += " ORDER BY id ";
            
            result = Conexao.stmt.executeQuery(sql);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                dadosTabela.add(linha);
            }
            
        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbLivros.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            
        });


        // permite seleção de apenas uma linha da tabela
        jtbLivros.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = jtbLivros.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(250);
                    break;
            }
        }
        jtbLivros.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }
        
    public boolean alterar(Livro objLivro){
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("UPDATE livro SET titulo=?, autor=?, genero=?, paginas=? WHERE id=? ");
            stmt.setString(1, objLivro.getTitulo());
            stmt.setString(2, objLivro.getAutor());
            stmt.setString(3, objLivro.getGenero());
            stmt.setInt(4, objLivro.getPaginas());
            stmt.setInt(5, objLivro.getId());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(Conexao.con);
        }
        
    }
    
    public boolean excluir(int id){
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("DELETE FROM livro WHERE id=?");
            stmt.setInt(1, id);
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(Conexao.con, stmt);
        }
        
}
}
