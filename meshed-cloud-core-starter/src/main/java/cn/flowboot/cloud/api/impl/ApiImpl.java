package cn.meshed.cloud.api.impl;

import cn.meshed.cloud.api.CommandExecute;
import cn.meshed.cloud.api.IApi;
import com.alibaba.cola.dto.PageQuery;
import com.alibaba.cola.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class ApiImpl<C,D,QL extends PageQuery,QI,
        LISTCMDEXE extends CommandExecute<QL>,
        ONECMDEXE extends CommandExecute<QI>,
        ADDCMDEXE extends CommandExecute<C>,
        UPDATECMDEXE extends CommandExecute<C>,
        DELCMDEXE extends CommandExecute<D>
        > implements IApi<C, D, QL, QI> {

    @Autowired
    private ADDCMDEXE saveCmdExe;
    @Autowired
    private UPDATECMDEXE updateCmdExe;
    @Autowired
    private LISTCMDEXE searchPageQryExe;
    @Autowired
    private ONECMDEXE searchOneQryExe;
    @Autowired
    private DELCMDEXE deleteCmdExe;


    /**
     * <h2>查询</h2>
     *
     * @param qry 查询参数
     * @return
     */
    @Override
    public Response searchPageList(QL qry) {
        return searchPageQryExe.execute(qry);
    }

    /**
     * 根据ID查询一个元素
     *
     * @param data
     * @return
     */
    @Override
    public Response getOneById(QI data) {
        return searchOneQryExe.execute(data);
    }



    /**
     * 删除
     *
     * @param cmd 删除数据
     */
    @Override
    public Response delete(D cmd) {
        return deleteCmdExe.execute(cmd);
    }

    @Override
    public Response save(C data) {
        return saveCmdExe.execute(data);
    }

    @Override
    public Response update(C data) {
        return updateCmdExe.execute(data);
    }
}
