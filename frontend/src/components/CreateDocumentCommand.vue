<template>
    <v-card outlined>
        <v-card-title>
            CreateDocument
        </v-card-title>

        <v-card-text>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <DocumentType offline label="Type" v-model="value.type" :editMode="editMode" @change="change"/>
            <DocumentTemplate offline label="DocumentTemplate" v-model="value.documentTemplate" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createDocument"
            >
                CreateDocument
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateDocumentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.title = '';
            this.value.content = '';
            this.value.type = {};
            this.value.documentTemplate = {};
        },
        watch: {
        },
        methods: {
            createDocument() {
                this.$emit('createDocument', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

