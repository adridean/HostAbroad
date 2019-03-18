package Commands;

import com.presentation.Command;
import com.presentation.Pair;

public class CommandSearchHost extends Command{

	@Override
	public Pair<Integer, Object> execute(Object transfer) {
		
		int result;
		SASearch saSearch = SAFactory.getInstance().createSASearch();
		
		result = saSearch.searchHost(transfer);
		
		return new Pair<Integer,Object>(result,transfer);
	}

}
