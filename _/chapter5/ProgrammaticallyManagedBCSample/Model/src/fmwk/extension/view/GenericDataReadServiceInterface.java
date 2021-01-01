package fmwk.extension.view;
/**
 * Generic dara retrieval contrects are specified here.
 * This corresponds to the operation in a typical viewObject
 */
public interface GenericDataReadServiceInterface {
    /**
     * Data retrieval logic for third part data source based on queryModel
     * @param queryModel
     * @return
     */
    public GenericRowCollection executeServiceForCollection(GenericQueryModel queryModel);
    /**
     * Gets total row count for queryModel
     * @param queryModel
     * @return
     */
    public long getTotalRowCount(GenericQueryModel queryModel);
}


