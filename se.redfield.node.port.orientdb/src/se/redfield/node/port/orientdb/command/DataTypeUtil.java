package se.redfield.node.port.orientdb.command;

import java.util.Date;

import org.knime.core.data.DataCell;
import org.knime.core.data.date.DateAndTimeCell;
import org.knime.core.data.def.BooleanCell;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.LongCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.data.uri.URIDataCell;

public class DataTypeUtil {

	public static Object getDataCellValue( DataCell dataCell) {
		Object result = null;
		if (dataCell instanceof StringCell) {
			StringCell cell = (StringCell) dataCell;
			result = cell.getStringValue();
		} else if (dataCell instanceof LongCell) {
			LongCell cell = (LongCell) dataCell;
			result = cell.getLongValue();
		} else if (dataCell instanceof BooleanCell) {
			BooleanCell cell = (BooleanCell) dataCell;
			result = cell.getBooleanValue();
		} else if (dataCell instanceof  IntCell) {
			IntCell cell = (IntCell) dataCell;
			result = cell.getIntValue();
		} else if (dataCell instanceof DoubleCell) {
			DoubleCell cell = (DoubleCell) dataCell;
			result = cell.getDoubleValue();
		}else if (dataCell instanceof DateAndTimeCell) {
			DateAndTimeCell cell = (DateAndTimeCell) dataCell;
			result = new Date(cell.getUTCTimeInMillis());
		}else if (dataCell instanceof URIDataCell) {
			URIDataCell cell = (URIDataCell) dataCell;
			result = cell.getStringValue();
		}

		return result;
	}

}
