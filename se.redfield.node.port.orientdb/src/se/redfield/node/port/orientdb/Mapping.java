package se.redfield.node.port.orientdb;

import org.knime.core.data.DataType;
import org.knime.core.data.collection.ListCell;
import org.knime.core.data.date.DateAndTimeCell;
import org.knime.core.data.def.BooleanCell;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.LongCell;
import org.knime.core.data.def.StringCell;

import com.orientechnologies.orient.core.metadata.schema.OType;

public class Mapping {

	public static DataType mapToDataType(OType oType) {
		return mapToDataType(oType, null, true);
	}

	public static DataType mapToDataType(OType oType, OType collectionValueType, boolean showCollectionsAsJson) {
		DataType dataType = null;
		switch (oType) {
		case STRING:
		case LINK:
			dataType = StringCell.TYPE;
			break;
		case INTEGER:
		case SHORT:
			dataType = IntCell.TYPE;
			break;
		case LONG:
			dataType = LongCell.TYPE;
			break;
		case FLOAT:
		case DOUBLE:
			dataType = DoubleCell.TYPE;
			break;
		case BOOLEAN:
			dataType = BooleanCell.TYPE;
			break;
		case DATE:
		case DATETIME:
			dataType = DateAndTimeCell.TYPE;
			break;
		case LINKBAG:
		case EMBEDDEDSET:
		case EMBEDDEDLIST:
			if (showCollectionsAsJson) {
				dataType = Constants.JSON_CELL_FACTORY.getDataType();
			} else {
				DataType collectionDataType = mapToDataType(collectionValueType, null, false);
				dataType = ListCell.getCollectionType(collectionDataType);
			}
			break;
		case EMBEDDEDMAP:
			dataType = Constants.JSON_CELL_FACTORY.getDataType();
			break;

		default:
			break;
		}
		return dataType;
	}
}
