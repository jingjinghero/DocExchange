<template>
  <div>
    <el-dialog :title="$t('application.objectPermission9')" 
      :append-to-body="true"
      :close-on-click-modal="false"
      :visible.sync="dialogVisible">
      <el-form :model="form">
        <el-row>
            <el-col v-if="!isEdit" :span="24">
              <el-form-item :label="$t('field.type')" :label-width="formLabelWidth">
                <el-select :disabled="isEdit"
                  v-model="form.targetType" :placeholder="$t('application.pleaseSelect')" style="display:block;">
                  <div v-for="(item,index) in typeData" :key="'T_'+index">
                    <el-option :label="item.name" :value="item.value" :key="index"></el-option>
                  </div>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item :label="$t('field.name')" :label-width="formLabelWidth">
                <div v-if="isEdit">
                  {{form.targetName}}
                </div>
                <div v-else>
                  <UserSelectInput v-if="form.targetType==1" v-model="form.targetName" v-bind:inputValue="form.targetName" :isRepeat="repeat"></UserSelectInput>
                  <RoleSelectInput v-else-if="form.targetType==2" v-model="form.targetName" v-bind:inputValue="form.targetName" :isRepeat="repeat"></RoleSelectInput>
                </div>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item :label="$t('field.permission')" :label-width="formLabelWidth">
                <el-select
                  v-model="form.permission" :placeholder="$t('application.pleaseSelect')" style="display:block;">
                  <div v-for="(item,index) in permissionData" :key="'P_'+index">
                    <el-option :label="item.name" :value="item.value" :key="index"></el-option>
                  </div>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item :label="$t('field.expireDate')" :label-width="formLabelWidth">
                <el-date-picker v-model="form.expireDate" type="date" :placeholder="$t('application.selectDate')" style="display:block;" value-format="yyyy-MM-dd HH:mm:ss"></el-date-picker>
              </el-form-item>
            </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">{{$t('application.cancel')}}</el-button>
        <el-button type="primary" @click="saveItem(form)">{{$t('application.ok')}}</el-button>
      </div>
    </el-dialog>
    <el-row>
      <el-col :span="6">
        <el-input
          v-model="inputKey"
          :placeholder="$t('application.placeholderSearch')"
          @change="search"
          prefix-icon="el-icon-search"
        ></el-input>
      </el-col>
      <el-col :span="1">
        <el-button type="primary" plain icon="el-icon-edit" @click="newItem()">{{$t('application.new')}}</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-table
      :data="permitList"
      border
      height="360"
      v-loading="loading"
      size="mini"
      style="width: 100%"
    >
      <el-table-column :label="$t('field.indexNumber')" type="index" width="60"></el-table-column>
       <el-table-column :label="$t('field.type')"  width="60">
          <template slot-scope="scope">
            <i v-if="scope.row.targetType==1" class="el-icon-user" :title="$t('application.user')"></i>
            <i v-if="scope.row.targetType==2" class="iconfont zisecm-friend" :title="$t('application.role')"></i>
          </template>
        </el-table-column>
      <el-table-column :label="$t('field.name')" prop="targetName" min-width="20%"></el-table-column>
      <el-table-column :label="$t('field.permission')" prop="permission" :formatter="permitFormatter" min-width="10%"></el-table-column>
      <el-table-column :label="$t('field.expireDate')" prop="expireDate" :formatter="dateFormatter" width="170"></el-table-column>
      <el-table-column :label="$t('application.operation')" width="160">
        <template slot-scope="scope">
          <el-button
            :plain="true"
            type="primary"
            size="small"
            icon="edit"
            @click="showItem(scope.row)"
          >{{$t('application.property')}}</el-button>
          <el-button
            :plain="true"
            type="danger"
            size="small"
            icon="delete"
            @click="delItem(scope.row)"
          >{{$t('application.delete')}}</el-button>
        </template>
      </el-table-column>
    </el-table>
      </el-col>
    </el-row>
  </div>
</template>

<script>
//动态表单
import UserSelectInput from '@/components/controls/UserSelectInput'
import RoleSelectInput from '@/components/controls/RoleSelectInput'

export default {
  data(){
    return {
      aclData:"",  //Acl信息
      aclId: "",
      inputKey:"",
      permitList:[],
      permitListFull:[],
      loading: false,
      dialogVisible: false,
      isEdit: false,
      repeat: true,
      form:{
        id:"",
        targetName: "",
        expireDate: null,
        targetType: 1,
        permission: 1,
        parentId:""
      },
      typeData: [
          {"name":this.$t('application.user'),
          "value":1},
          {"name":this.$t('application.role'),
          "value":2}
      ],
      permissionData: [
          {"name":this.$t('application.objectPermission1'),
          "value":1},
          {"name":this.$t('application.objectPermission2'),
          "value":2},
          {"name":this.$t('application.objectPermission3'),
          "value":3},
          {"name":this.$t('application.objectPermission4'),
          "value":4},
          {"name":this.$t('application.objectPermission5'),
          "value":5},
          {"name":this.$t('application.objectPermission6'),
          "value":6},
          {"name":this.$t('application.objectPermission7'),
          "value":7},
          {"name":this.$t('application.objectPermission8'),
          "value":8},
          {"name":this.$t('application.objectPermission9'),
          "value":9}
      ],
      formLabelWidth: "120px"
    }
  },
  components: {
    UserSelectInput:UserSelectInput,
    RoleSelectInput:RoleSelectInput
  },
  props:{
    name:{//Acl 名称
      type:String
    },
    id:{//Acl Id
      type:String
    }
  },
  methods:{
    permitFormatter(row, column) {
      //console.log(column);
      let data = row[column.property];
      return this.$t('application.objectPermission'+data);
    },
    dateFormatter(row, column) {
      //console.log(column);
      let datetime = row[column.property];
      return this.datetimeFormat(datetime);
    },
    loadAcl(){
      let _self = this;
      let aclUrl = "/acl/getAclById";
      let pdata = _self.id;
      if( !_self.id && _self.name){
        aclUrl = "/acl/getAclByName";
        pdata = _self.name;
      }
      
      var m = new Map();
      m.set('itemInfo',name);//ID 或类型
      m.set('lang',_self.getLang());
      
      //console.log(name);
      _self.axios({
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        method: "post",
        data: pdata,
        url: aclUrl
      }).then(function(response){
        //console.log(response.data.data);
        _self.aclData = response.data.data;
        _self.refreshData();

      });
    },
    showItem(inData){
      this.isEdit = true;
      this.form = inData;
      this.dialogVisible = true;
    },
    newItem(){
      this.isEdit = false;
      this.form = {
        id:"",
        parentId: this.aclData.id,
        targetName: "",
        expireDate: null,
        targetType: 1,
        permission: 1
      }
      this.dialogVisible = true;
    },
    saveItem(inData){
      let _self = this;
      console.log(inData);
      _self.axios({
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        method: "post",
        data: inData,
        url: "/acl/grantPermit"
      }).then(function(response){
        if(response.data.code == 1){
          _self.dialogVisible = false;
          _self.refreshData();
          _self.$message(_self.$t('message.newSuccess'));
        }else{
          _self.$message.error(_self.$t('message.newFailured'));
        }
      });
    },
    delItem(inData){
      let _self = this;
      //console.log(name);
      _self.axios({
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        method: "post",
        data: inData,
        url: "/acl/revokePermit"
      }).then(function(response){
        if(response.data.code == 1){
          _self.refreshData();
          _self.$message(_self.$t('message.deleteSuccess'));
        }else{
          _self.$message.error(_self.$t('message.deleteFailured'));
        }
      });
    },
    /*
    
    */
    refreshData(){
      let _self = this;
      //console.log(name);
      _self.axios({
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        method: "post",
        data: _self.aclData.id,
        url: "/acl/getPermitsById"
      }).then(function(response){
        console.log(JSON.stringify(response.data.data));
        _self.permitList = response.data.data;
        _self.permitListFull = response.data.data;
      });
    },
    search(){
      let _self = this;
      _self.permitList = _self.permitListFull.filter(function(item){
        //console.log(item);
        return item.targetName.match(_self.inputKey);
      });
    }
     
  },
  mounted(){
    this.loadAcl();
  },
  created(){
   
  }
}
</script>

<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
}
li {
  /* display: inline-block; */
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>