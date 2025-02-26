<template>
    <v-card outlined>
        <v-card-title>
            RetrieveDocumentHistory
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="Page" v-model="value.page" :editMode="editMode"/>
            <Number label="PageSize" v-model="value.pageSize" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="retrieveDocumentHistory"
            >
                RetrieveDocumentHistory
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
        name: 'RetrieveDocumentHistoryCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = '';
            this.value.page = 0;
            this.value.pageSize = 0;
        },
        watch: {
        },
        methods: {
            retrieveDocumentHistory() {
                this.$emit('retrieveDocumentHistory', this.value);
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

