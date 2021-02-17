package es.pildoras.crud.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.pildoras.crud.dao.IClienteDao;
import es.pildoras.entity.Cliente;

@Repository
public class ClienteDao implements IClienteDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// Obtener la sesión
		Session session = this.sessionFactory.getCurrentSession();

		// Crear la consulta (query)
		Query<Cliente> query = session.createQuery("from Cliente", Cliente.class);

		// Ejecutar la query y devolver resultados.
		return query.getResultList();
	}

	@Override
	@Transactional
	public void crear(Cliente cliente) {
		// Obtener la sesión
		Session session = this.sessionFactory.getCurrentSession();

		// Insertar el cliente
		session.save(cliente);
	}

	@Override
	@Transactional
	public Cliente obtenerCliente(int id) {
		// Obtener la sesión
		Session session = this.sessionFactory.getCurrentSession();

		// Obtener el cliente
		return session.get(Cliente.class, id);
	}

	@Override
	@Transactional
	public void modificar(Cliente cliente) {
		// Obtener la sesión
		Session session = this.sessionFactory.getCurrentSession();

		// Guardar el cliente
		session.update(cliente);
	}

	@Override
	@Transactional
	public void eliminar(int id) {
		// Obtener la sesión
		Session session = this.sessionFactory.getCurrentSession();

		// Eliminar el cliente
		session.createQuery("DELETE Cliente WHERE id = :id").setParameter("id", id).executeUpdate();
	}
}
