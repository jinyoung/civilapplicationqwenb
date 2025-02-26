<template>
    <v-card outlined>
        <v-card-title>
            CancelServiceApplication
        </v-card-title>

        <v-card-text>
            <String label="ApplicationId" v-model="value.applicationId" :editMode="editMode"/>
            <String label="CancellationReason" v-model="value.cancellationReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="cancelServiceApplication"
            >
                CancelServiceApplication
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
        name: 'CancelServiceApplicationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.applicationId = '';
            this.value.cancellationReason = '';
        },
        watch: {
        },
        methods: {
            cancelServiceApplication() {
                this.$emit('cancelServiceApplication', this.value);
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

