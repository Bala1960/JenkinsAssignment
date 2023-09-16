import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class JsonValidation {

	@Test
	public void NtJsonValidation() throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V4);
		File InputJson = new File("src/test/resources/Input..json");
		InputStream inputSchema = new FileInputStream("src/test/resources/Schema.json");
		JsonNode jsonnode = mapper.readTree(InputJson);
		JsonSchema schema = factory.getSchema(inputSchema);
		
		Set<ValidationMessage> result = schema.validate(jsonnode);
		if(result.isEmpty())
		{
			System.out.println("No validation error");
		}
		else
		{
			for (ValidationMessage message:result)
			{
				System.out.println(message);
			}
		}
		
	}

}
