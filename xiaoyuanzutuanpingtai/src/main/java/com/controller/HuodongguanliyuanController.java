
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 活动管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huodongguanliyuan")
public class HuodongguanliyuanController {
    private static final Logger logger = LoggerFactory.getLogger(HuodongguanliyuanController.class);

    @Autowired
    private HuodongguanliyuanService huodongguanliyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("活动管理员".equals(role))
            params.put("huodongguanliyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huodongguanliyuanService.queryPage(params);

        //字典表数据转换
        List<HuodongguanliyuanView> list =(List<HuodongguanliyuanView>)page.getList();
        for(HuodongguanliyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongguanliyuanEntity huodongguanliyuan = huodongguanliyuanService.selectById(id);
        if(huodongguanliyuan !=null){
            //entity转view
            HuodongguanliyuanView view = new HuodongguanliyuanView();
            BeanUtils.copyProperties( huodongguanliyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongguanliyuanEntity huodongguanliyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huodongguanliyuan:{}",this.getClass().getName(),huodongguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuodongguanliyuanEntity> queryWrapper = new EntityWrapper<HuodongguanliyuanEntity>()
            .eq("username", huodongguanliyuan.getUsername())
            .or()
            .eq("huodongguanliyuan_phone", huodongguanliyuan.getHuodongguanliyuanPhone())
            .or()
            .eq("huodongguanliyuan_id_number", huodongguanliyuan.getHuodongguanliyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongguanliyuanEntity huodongguanliyuanEntity = huodongguanliyuanService.selectOne(queryWrapper);
        if(huodongguanliyuanEntity==null){
            huodongguanliyuan.setCreateTime(new Date());
            huodongguanliyuan.setPassword("123456");
            huodongguanliyuanService.insert(huodongguanliyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者活动管理员手机号或者活动管理员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuodongguanliyuanEntity huodongguanliyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huodongguanliyuan:{}",this.getClass().getName(),huodongguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuodongguanliyuanEntity> queryWrapper = new EntityWrapper<HuodongguanliyuanEntity>()
            .notIn("id",huodongguanliyuan.getId())
            .andNew()
            .eq("username", huodongguanliyuan.getUsername())
            .or()
            .eq("huodongguanliyuan_phone", huodongguanliyuan.getHuodongguanliyuanPhone())
            .or()
            .eq("huodongguanliyuan_id_number", huodongguanliyuan.getHuodongguanliyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongguanliyuanEntity huodongguanliyuanEntity = huodongguanliyuanService.selectOne(queryWrapper);
        if("".equals(huodongguanliyuan.getHuodongguanliyuanPhoto()) || "null".equals(huodongguanliyuan.getHuodongguanliyuanPhoto())){
                huodongguanliyuan.setHuodongguanliyuanPhoto(null);
        }
        if(huodongguanliyuanEntity==null){
            huodongguanliyuanService.updateById(huodongguanliyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者活动管理员手机号或者活动管理员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huodongguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuodongguanliyuanEntity> huodongguanliyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuodongguanliyuanEntity huodongguanliyuanEntity = new HuodongguanliyuanEntity();
//                            huodongguanliyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //huodongguanliyuanEntity.setPassword("123456");//密码
//                            huodongguanliyuanEntity.setHuodongguanliyuanUuidNumber(data.get(0));                    //活动管理员编号 要改的
//                            huodongguanliyuanEntity.setHuodongguanliyuanName(data.get(0));                    //活动管理员姓名 要改的
//                            huodongguanliyuanEntity.setHuodongguanliyuanPhone(data.get(0));                    //活动管理员手机号 要改的
//                            huodongguanliyuanEntity.setHuodongguanliyuanIdNumber(data.get(0));                    //活动管理员身份证号 要改的
//                            huodongguanliyuanEntity.setHuodongguanliyuanPhoto("");//详情和图片
//                            huodongguanliyuanEntity.setHuodongguanliyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            huodongguanliyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            huodongguanliyuanEntity.setCreateTime(date);//时间
                            huodongguanliyuanList.add(huodongguanliyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //活动管理员编号
                                if(seachFields.containsKey("huodongguanliyuanUuidNumber")){
                                    List<String> huodongguanliyuanUuidNumber = seachFields.get("huodongguanliyuanUuidNumber");
                                    huodongguanliyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huodongguanliyuanUuidNumber = new ArrayList<>();
                                    huodongguanliyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huodongguanliyuanUuidNumber",huodongguanliyuanUuidNumber);
                                }
                                //活动管理员手机号
                                if(seachFields.containsKey("huodongguanliyuanPhone")){
                                    List<String> huodongguanliyuanPhone = seachFields.get("huodongguanliyuanPhone");
                                    huodongguanliyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> huodongguanliyuanPhone = new ArrayList<>();
                                    huodongguanliyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("huodongguanliyuanPhone",huodongguanliyuanPhone);
                                }
                                //活动管理员身份证号
                                if(seachFields.containsKey("huodongguanliyuanIdNumber")){
                                    List<String> huodongguanliyuanIdNumber = seachFields.get("huodongguanliyuanIdNumber");
                                    huodongguanliyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huodongguanliyuanIdNumber = new ArrayList<>();
                                    huodongguanliyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("huodongguanliyuanIdNumber",huodongguanliyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<HuodongguanliyuanEntity> huodongguanliyuanEntities_username = huodongguanliyuanService.selectList(new EntityWrapper<HuodongguanliyuanEntity>().in("username", seachFields.get("username")));
                        if(huodongguanliyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongguanliyuanEntity s:huodongguanliyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //活动管理员编号
                        List<HuodongguanliyuanEntity> huodongguanliyuanEntities_huodongguanliyuanUuidNumber = huodongguanliyuanService.selectList(new EntityWrapper<HuodongguanliyuanEntity>().in("huodongguanliyuan_uuid_number", seachFields.get("huodongguanliyuanUuidNumber")));
                        if(huodongguanliyuanEntities_huodongguanliyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongguanliyuanEntity s:huodongguanliyuanEntities_huodongguanliyuanUuidNumber){
                                repeatFields.add(s.getHuodongguanliyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [活动管理员编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //活动管理员手机号
                        List<HuodongguanliyuanEntity> huodongguanliyuanEntities_huodongguanliyuanPhone = huodongguanliyuanService.selectList(new EntityWrapper<HuodongguanliyuanEntity>().in("huodongguanliyuan_phone", seachFields.get("huodongguanliyuanPhone")));
                        if(huodongguanliyuanEntities_huodongguanliyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongguanliyuanEntity s:huodongguanliyuanEntities_huodongguanliyuanPhone){
                                repeatFields.add(s.getHuodongguanliyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [活动管理员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //活动管理员身份证号
                        List<HuodongguanliyuanEntity> huodongguanliyuanEntities_huodongguanliyuanIdNumber = huodongguanliyuanService.selectList(new EntityWrapper<HuodongguanliyuanEntity>().in("huodongguanliyuan_id_number", seachFields.get("huodongguanliyuanIdNumber")));
                        if(huodongguanliyuanEntities_huodongguanliyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuodongguanliyuanEntity s:huodongguanliyuanEntities_huodongguanliyuanIdNumber){
                                repeatFields.add(s.getHuodongguanliyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [活动管理员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huodongguanliyuanService.insertBatch(huodongguanliyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        HuodongguanliyuanEntity huodongguanliyuan = huodongguanliyuanService.selectOne(new EntityWrapper<HuodongguanliyuanEntity>().eq("username", username));
        if(huodongguanliyuan==null || !huodongguanliyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(huodongguanliyuan.getId(),username, "huodongguanliyuan", "活动管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","活动管理员");
        r.put("username",huodongguanliyuan.getHuodongguanliyuanName());
        r.put("tableName","huodongguanliyuan");
        r.put("userId",huodongguanliyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HuodongguanliyuanEntity huodongguanliyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<HuodongguanliyuanEntity> queryWrapper = new EntityWrapper<HuodongguanliyuanEntity>()
            .eq("username", huodongguanliyuan.getUsername())
            .or()
            .eq("huodongguanliyuan_phone", huodongguanliyuan.getHuodongguanliyuanPhone())
            .or()
            .eq("huodongguanliyuan_id_number", huodongguanliyuan.getHuodongguanliyuanIdNumber())
            ;
        HuodongguanliyuanEntity huodongguanliyuanEntity = huodongguanliyuanService.selectOne(queryWrapper);
        if(huodongguanliyuanEntity != null)
            return R.error("账户或者活动管理员手机号或者活动管理员身份证号已经被使用");
        huodongguanliyuan.setCreateTime(new Date());
        huodongguanliyuanService.insert(huodongguanliyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HuodongguanliyuanEntity huodongguanliyuan = new HuodongguanliyuanEntity();
        huodongguanliyuan.setPassword("123456");
        huodongguanliyuan.setId(id);
        huodongguanliyuanService.updateById(huodongguanliyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        HuodongguanliyuanEntity huodongguanliyuan = huodongguanliyuanService.selectOne(new EntityWrapper<HuodongguanliyuanEntity>().eq("username", username));
        if(huodongguanliyuan!=null){
            huodongguanliyuan.setPassword("123456");
            boolean b = huodongguanliyuanService.updateById(huodongguanliyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrHuodongguanliyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HuodongguanliyuanEntity huodongguanliyuan = huodongguanliyuanService.selectById(id);
        if(huodongguanliyuan !=null){
            //entity转view
            HuodongguanliyuanView view = new HuodongguanliyuanView();
            BeanUtils.copyProperties( huodongguanliyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = huodongguanliyuanService.queryPage(params);

        //字典表数据转换
        List<HuodongguanliyuanView> list =(List<HuodongguanliyuanView>)page.getList();
        for(HuodongguanliyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuodongguanliyuanEntity huodongguanliyuan = huodongguanliyuanService.selectById(id);
            if(huodongguanliyuan !=null){


                //entity转view
                HuodongguanliyuanView view = new HuodongguanliyuanView();
                BeanUtils.copyProperties( huodongguanliyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongguanliyuanEntity huodongguanliyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huodongguanliyuan:{}",this.getClass().getName(),huodongguanliyuan.toString());
        Wrapper<HuodongguanliyuanEntity> queryWrapper = new EntityWrapper<HuodongguanliyuanEntity>()
            .eq("username", huodongguanliyuan.getUsername())
            .or()
            .eq("huodongguanliyuan_phone", huodongguanliyuan.getHuodongguanliyuanPhone())
            .or()
            .eq("huodongguanliyuan_id_number", huodongguanliyuan.getHuodongguanliyuanIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuodongguanliyuanEntity huodongguanliyuanEntity = huodongguanliyuanService.selectOne(queryWrapper);
        if(huodongguanliyuanEntity==null){
            huodongguanliyuan.setCreateTime(new Date());
        huodongguanliyuan.setPassword("123456");
        huodongguanliyuanService.insert(huodongguanliyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者活动管理员手机号或者活动管理员身份证号已经被使用");
        }
    }


}
