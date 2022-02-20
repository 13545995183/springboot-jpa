new Vue({
    el: '#app',
    data() {
        return {
            userCenterDialog: false,
            editableTabsValue: '',
            editableTabs: [],
            sysUser: {},
            sysMenu: [],
            avatar: '',
            actionUrl: 'common/file/upload',
            userCenterModel: 'first',
            baseForm: {
                id: '',
                sex: '',
                birthDate: '',
                phone: '',
                province: '',
                city: '',
                area: '',
                address: '',
                avatar: ''
            },
            baseFormRules: {
                sex: [
                    {required: true, message: '请选择', trigger: 'blur'}
                ],
                birthDate: [
                    {required: true, message: '请选择', trigger: 'blur'}
                ],
                phone: [
                    {required: true, message: '请输入', trigger: 'blur'},
                    {min: 11, max: 11, message: '手机号码格式不正确', trigger: 'blur'}
                ]
            },
            pwdForm: {
                oldPwd: '',
                newPwd: '',
                confirmPwd: ''
            },
            pwdFormRules: {
                oldPwd: [
                    {required: true, message: '请输入', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
                ],
                newPwd: [
                    {required: true, message: '请输入', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
                ],
                confirmPwd: [
                    {required: true, message: '请输入', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur'}
                ]
            },
            regionList: []
        }
    },
    methods: {
        handleCommand(cmd) {
            if (cmd == 'logout') {
                axios.post('logout').then((res) => {
                    if (res.code == '0000' || res.code == '9999') {
                        localStorage.clear();
                        parent.location.href ='';
                    }
                });
            } else if (cmd == 'userCenter') {
                this.userCenterDialog = true;
                const sysUser = JSON.parse(localStorage.getItem("jsbb-sysUser"));
                this.baseForm.id = sysUser.id;
                this.baseForm.sex = sysUser.sex;
                this.baseForm.birthDate = sysUser.birthDate;
                this.baseForm.phone = sysUser.phone;
                this.baseForm.province = sysUser.province;
                this.baseForm.city = sysUser.city;
                this.baseForm.area = sysUser.area;
                this.baseForm.address = sysUser.address;
                this.baseForm.avatar = sysUser.avatar;
            }
        },
        addTab(tabName, tabUrl) {
            let isExist = false;
            let tabs = this.editableTabs;
            tabs.forEach((tab, index) => {
                if (tab.title === tabName) {
                    isExist = true;
                    return;
                }
            });
            if (isExist) {
                this.editableTabsValue = tabUrl;
                return;
            }
            tabs.push({
                title: tabName,
                name: tabUrl,
                content: tabUrl
            });
            this.editableTabsValue = tabUrl;
        },
        removeTab(tabName) {
            let tabs = this.editableTabs;
            let activeName = this.editableTabsValue;
            if (activeName === tabName) {
                tabs.forEach((tab, index) => {
                    if (tab.name === tabName) {
                        let nextTab = tabs[index + 1] || tabs[index - 1];
                        if (nextTab) {
                            activeName = nextTab.name;
                        }
                    }
                });
            }
            this.editableTabsValue = activeName;
            this.editableTabs = tabs.filter(tab => tab.name !== tabName);
        },
        handleClick(tab, event) {
        },
        handleAvatarSuccess(idx, res, file, name) {
            if (res.code == '0000') {
                this.baseForm.avatar = res.data.url;
            }
        },
        beforeAvatarUpload(file) {
            const isLt2M = file.size / 1024 / 1024 < 2;
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过2MB!');
            }
            return isLt2M;
        },
        baseFormSave() {
            this.$refs.baseForm.validate((valid) => {
                if (valid) {
                    this.userCenterDialog = false;
                    let saveParam = this.baseForm;
                    axios.post('sys/user/data/update', JSON.parse(JSON.stringify(saveParam)))
                    .then((res) => {
                        if (res.code == '0000') {
                            const sysUser = JSON.parse(localStorage.getItem("jsbb-sysUser"));
                            sysUser.id = saveParam.id;
                            sysUser.sex = saveParam.sex;
                            sysUser.birthDate = saveParam.birthDate;
                            sysUser.phone = saveParam.phone;
                            sysUser.province = saveParam.province;
                            sysUser.city = saveParam.city;
                            sysUser.area = saveParam.area;
                            sysUser.address = saveParam.address;
                            sysUser.avatar = saveParam.avatar;
                            localStorage.setItem('jsbb-sysUser', JSON.stringify(sysUser));
                            this.$message({
                                type: 'success',
                                message: '修改成功'
                            });
                        } else {
                            this.$message.error(res.message);
                        }
                    });
                } else {
                    return false;
                }
            });
        },
        pwdFormSave() {
            this.userCenterDialog = false;
            this.$message({
                type: 'success',
                message: '待开发'
            });
        }
    },
    created() {
        this.sysUser = JSON.parse(localStorage.getItem("jsbb-sysUser"));
        this.sysMenu = JSON.parse(localStorage.getItem("jsbb-sysMenu"));
        this.avatar = this.sysUser.avatar;
    }
});