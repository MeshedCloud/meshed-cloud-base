package ${classPackage}.${domainName}.web;

import ${classPackage}.${domainName}.api.${Class}Service;
import ${classPackage}.${domainName}.dto.cmd.${Class}AddCmd;
import ${classPackage}.${domainName}.dto.cmd.${Class}DelCmd;
import ${classPackage}.${domainName}.dto.query.${Class}ByIdQry;
import ${classPackage}.${domainName}.dto.query.${Class}ListQry;
import RestApi;
import com.alibaba.cola.dto.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>动态表单</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@Api(tags = "动态表单")
@RestApi(path = "/dynamic/form/",prefix = "platform")
public class ${Class}Controller {

    private final ${Class}Service ${class}Service;

    /**
     * 查询列表
     * @param ${class}ListQry 查询参数
     * @return
     */
    @ApiOperation("查询列表")
    @GetMapping("list")
    public Response list(${Class}ListQry ${class}ListQry){
        return ${class}Service.searchPageList(${class}ListQry);
    }

    /**
     * 查询详情
     * @param id id
     * @return
     */
    @ApiOperation("查询详情")
    @GetMapping("desc/{id}")
    public Response get${Class}ById(@PathVariable("id") Integer id){
        ${Class}ByIdQry ${class}ByIdQry = new ${Class}ByIdQry();
        ${class}ByIdQry.setId(id);
        return ${class}Service.getOneById(${class}ByIdQry);
    }



    /**
     * 查询表单主体
     * @param cmd 保存数据
     * @return
     */
    @ApiOperation("保存")
    @PostMapping("save")
    public Response save${Class}(@RequestBody ${Class}AddCmd cmd){
        if (cmd.getId() != null && cmd.getId() > 0){
            ${class}Service.update(cmd);
        } else {
            ${class}Service.save(cmd);
        }
        return Response.buildSuccess();
    }

    /**
     * 删除
     * @param id id
     * @return
     */
    @ApiOperation("删除")
    @DeleteMapping("delete/{id}")
    public Response delete${Class}(@PathVariable("id") Integer id){
        ${Class}DelCmd ${class}DelCmd = new ${Class}DelCmd();
        ${class}DelCmd.setId(id);
        return ${class}Service.delete(${class}DelCmd);
    }



}
