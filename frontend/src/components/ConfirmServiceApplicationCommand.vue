<template>
    <v-card outlined>
        <v-card-title>
            ConfirmServiceApplication
        </v-card-title>

        <v-card-text>
            <String label="ApplicationId" v-model="value.applicationId" :editMode="editMode"/>
            <ApplicationStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="confirmServiceApplication"
            >
                ConfirmServiceApplication
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
        name: 'ConfirmServiceApplicationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.applicationId = '';
            this.value.status = {};
        },
        watch: {
        },
        methods: {
            confirmServiceApplication() {
                this.$emit('confirmServiceApplication', this.value);
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

