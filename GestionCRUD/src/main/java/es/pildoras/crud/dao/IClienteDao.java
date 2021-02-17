package es.pildoras.crud.dao;

import java.util.List;

import es.pildoras.entity.Cliente;

public interface IClienteDao {
	List<Cliente> getClientes();
	void crear(Cliente cliente);
	Cliente obtenerCliente(int id);
	void modificar(Cliente cliente);
	void eliminar(int id);
}