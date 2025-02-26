<template>
    <v-card outlined>
        <v-card-title>
            CreateQualificationCheck
        </v-card-title>

        <v-card-text>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="Criteria" v-model="value.criteria" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createQualificationCheck"
            >
                CreateQualificationCheck
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
        name: 'CreateQualificationCheckCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.userId = '';
            this.value.criteria = '';
        },
        watch: {
        },
        methods: {
            createQualificationCheck() {
                this.$emit('createQualificationCheck', this.value);
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

