<template>

    <v-card outlined>
        <v-card-title>
            ContactInformation
        </v-card-title>

        <v-card-text>
            <String label="Phone" v-model="value.phone" :editMode="editMode"/>
            <String label="Email" v-model="value.email" :editMode="editMode"/>
            <String label="Address" v-model="value.address" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'ContactInformation',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'phone': '',
                    'email': '',
                    'address': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('phone' in this.value)) {
                    this.value.phone = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('email' in this.value)) {
                    this.value.email = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('address' in this.value)) {
                    this.value.address = '';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

