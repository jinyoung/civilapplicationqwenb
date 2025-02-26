<template>
    <v-card outlined>
        <v-card-title>
            UpdateDocumentStatus
        </v-card-title>

        <v-card-text>
            <String label="DocumentId" v-model="value.documentId" :editMode="editMode"/>
            <ProcessingStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateDocumentStatus"
            >
                UpdateDocumentStatus
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
        name: 'UpdateDocumentStatusCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.documentId = '';
            this.value.status = {};
        },
        watch: {
        },
        methods: {
            updateDocumentStatus() {
                this.$emit('updateDocumentStatus', this.value);
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

