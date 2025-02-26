<template>
    <v-card outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            문서 관리 # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            문서 관리
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <String v-if="editMode" label="DocumentId" v-model="value.documentId" :editMode="editMode" :inputUI="''"/>
            <String label="Title" v-model="value.title" :editMode="editMode" :inputUI="''"/>
            <String label="Content" v-model="value.content" :editMode="editMode" :inputUI="''"/>
            <DocumentType offline label="Type" v-model="value.type" :editMode="editMode" @change="change"/>
            <ProcessingStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <DocumentTemplate offline label="문서 템플릿" v-model="value.documentTemplate" :editMode="editMode" @change="change"/>
            <DocumentProcessing offline label="문서 처리" v-model="value.documentProcessing" :editMode="editMode" @change="change"/>
            <ServiceApplicationId offline label="serviceApplicationId" v-model="value.serviceApplicationId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions style="background-color: white;">
            <v-spacer></v-spacer>
            <div v-if="!editMode">
                <v-btn
                    color="primary"
                    text
                    @click="edit"
                >
                    수정
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                >
                    삭제
                </v-btn>
            </div>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                저장
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openCreateDocument"
            >
                CreateDocument
            </v-btn>
            <v-dialog v-model="createDocumentDiagram" width="500">
                <CreateDocumentCommand
                    @closeDialog="closeCreateDocument"
                    @createDocument="createDocument"
                ></CreateDocumentCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openUpdateDocumentStatus"
            >
                UpdateDocumentStatus
            </v-btn>
            <v-dialog v-model="updateDocumentStatusDiagram" width="500">
                <UpdateDocumentStatusCommand
                    @closeDialog="closeUpdateDocumentStatus"
                    @updateDocumentStatus="updateDocumentStatus"
                ></UpdateDocumentStatusCommand>
            </v-dialog>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openRetrieveDocumentHistory"
            >
                RetrieveDocumentHistory
            </v-btn>
            <v-dialog v-model="retrieveDocumentHistoryDiagram" width="500">
                <RetrieveDocumentHistoryCommand
                    @closeDialog="closeRetrieveDocumentHistory"
                    @retrieveDocumentHistory="retrieveDocumentHistory"
                ></RetrieveDocumentHistoryCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'DocumentManagementDocumentManagement',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
            },
            createDocumentDiagram: false,
            updateDocumentStatusDiagram: false,
            retrieveDocumentHistoryDiagram: false,
        }),
	async created() {
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/documentManagements'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async createDocument() {
                try {
                    if(!this.offline){
                        var temp = await axios.post(axios.fixUrl(this.value._links['/createdocument'].href))
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    }

                    this.editMode = false;
                    
                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);
                
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            async updateDocumentStatus(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['updatedocumentstatus'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeUpdateDocumentStatus();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openUpdateDocumentStatus() {
                this.updateDocumentStatusDiagram = true;
            },
            closeUpdateDocumentStatus() {
                this.updateDocumentStatusDiagram = false;
            },
        },
    }
</script>

