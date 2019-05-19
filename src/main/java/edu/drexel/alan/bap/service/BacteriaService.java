package edu.drexel.alan.bap.service;

import java.util.List;

import edu.drexel.alan.bap.model.Bacteria;

public interface BacteriaService {
	
	public List<Bacteria> parse(String filename) throws ServiceException;
	
	public void load(List<Bacteria> list) throws ServiceException;
	
	public List<Bacteria> findAll() throws ServiceException;
	
	public Bacteria findById(int id) throws ServiceException;
	
	public int insert(Bacteria bacteria) throws ServiceException;
	
	public int update(Bacteria bacteria) throws ServiceException;
	
	public void delete(int id) throws ServiceException;

}
