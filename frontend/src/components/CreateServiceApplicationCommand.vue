<template>
    <v-card outlined>
        <v-card-title>
            CreateServiceApplication
        </v-card-title>

        <v-card-text>
            <ApplicationType offline label="ApplicationType" v-model="value.applicationType" :editMode="editMode" @change="change"/>
            <CitizenProfile offline label="CitizenProfile" v-model="value.citizenProfile" :editMode="editMode" @change="change"/>
            <ContactInformation offline label="ContactInformation" v-model="value.contactInformation" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createServiceApplication"
            >
                CreateServiceApplication
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
        name: 'CreateServiceApplicationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.applicationType = {};
            this.value.citizenProfile = {};
            this.value.contactInformation = {};
        },
        watch: {
        },
        methods: {
            createServiceApplication() {
                this.$emit('createServiceApplication', this.value);
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

