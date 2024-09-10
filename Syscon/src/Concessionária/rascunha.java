
// Código do cliente
		JLabel labcodcli = new JLabel("Cliente cod.");
		labcodcli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodcli.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodcli);
		
		JLabel labcodcliform = new JLabel("formato 9999");
		labcodcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodcliform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodcliform);

		clicod = new JFormattedTextField();
		clicod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clicod.setBounds(229, 125, 160, 35);
		frame.getContentPane().add(clicod);



	// Método para verificar se o código do cliente já existe no banco de dados
	private void verificarCodigoCliente() {
		String codigo = clicod.getText();
		String sql = "SELECT nome, whatsapp, veiculo FROM cliente WHERE codigo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				// Se o cliente existir, preencher os campos
				clinome.setText(rs.getString("nome"));
				cliwhats.setText(rs.getString("whatsapp"));
				cadveicli.setText(rs.getString("veiculo"));
				JOptionPane.showMessageDialog(frame, "Cliente encontrado!");
			} else {
				JOptionPane.showMessageDialog(frame, "Cliente não encontrado. Continue com o cadastro.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
