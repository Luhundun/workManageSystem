package com.lu.workManageSystem.service.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void init();

	void store(MultipartFile file);

	//带作业id前缀存
	void prefixStore(MultipartFile file,String prefix);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	//带作业id前缀取
	Resource loadPrefixAndAsResource(String filename,int prefix);

	void deleteFile(String fileName);

	void deleteAll();

}
