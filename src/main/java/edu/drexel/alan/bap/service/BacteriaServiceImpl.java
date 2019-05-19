package edu.drexel.alan.bap.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.drexel.alan.bap.model.Bacteria;
import edu.drexel.alan.bap.repo.BacteriaRepo;


@Service
public class BacteriaServiceImpl implements BacteriaService {

	private static final String UNKNOWN = "UNKNOWN";

	@Autowired
	private BacteriaRepo bacteriaRepo; 
	
	@Override
	public List<Bacteria> parse(String filename) throws ServiceException {
		System.out.println("Parsing " + filename + " ..." );
		List<Bacteria> list = new ArrayList<>();
	
		// Open the csv file
		// for each line in svc, create a Bacteria object
		// put Bacteria in the list.
		Reader in;
		try {
			in = new FileReader(filename);
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				Bacteria bacteria = new Bacteria();
				
				String name = record.get("Name");
				String taxId = record.get("TaxID");
				String lineage = record.get("Lineage");
				String bacteriaCount = record.get("Count");
				String proportionAll = record.get("Proportion_All(%)");
				String proportionClassified = record.get("Proportion_Classified(%)");
				
				if (taxId.equals(UNKNOWN)) {
					continue;
				} 
				
				bacteria.setName(name);
				bacteria.setTaxId(Integer.parseInt(taxId));
				bacteria.setLineage(lineage);
				bacteria.setBacteriaCount(Integer.parseInt(bacteriaCount));
				bacteria.setProportionAll(Double.parseDouble(proportionAll));
				bacteria.setProportionClassified(Double.parseDouble(proportionClassified));
				
				list.add(bacteria);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public void load(List<Bacteria> list) throws ServiceException {
		System.out.println("Loading " + list.size() + " records..." );
		for (Bacteria bacteria : list) {
			bacteriaRepo.save(bacteria);
		}
	}
	
	@Override
	public List<Bacteria> findAll() throws ServiceException {
		//return bacteriaRepo.findAll();
		List<Bacteria> list = bacteriaRepo.findAll();
		return list.subList(0, 10);
	}
	
	@Override
	public Bacteria findById(int id) throws ServiceException {
		Optional<Bacteria> result = bacteriaRepo.findById(id);
		return result.get();
	}

	@Override
	public int insert(Bacteria bacteria) throws ServiceException {
		// TODO Auto-generated method stub
		Bacteria result = bacteriaRepo.save(bacteria);
		return ( (result != null) ? 1 : 0 ); 
	}

	@Override
	public int update(Bacteria bacteria) throws ServiceException {
		Bacteria result = bacteriaRepo.save(bacteria);
		return ( (result != null) ? 1 : 0 ); 
	}

	@Override
	public void delete(int id) throws ServiceException {
		bacteriaRepo.deleteById(id);
	}


}
