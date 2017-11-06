(function (vue) {
	var Bus = new Vue();
    'use strict';
    var VueTreeItem = Vue.extend({
        template: '<li :class="{parent_li: node.isParent}">' +
        '<i v-if="node.isParent" v-on:click="toggle(node)" class="fa icon-open-state" :class=\'{"fa-plus-square-o": !node.isOpen, "fa-minus-square-o": node.isOpen}\'></i>' +
        '<span :title="node.title">' +
        '<i v-if="showIcon(node)" :class="nodeClass(node)"></i> {{node.class_name}}</span>' +
        '<a v-show="node.isOpen" class="ml5" href="javascript:" title="Add" v-on:click="Add(node)" ><i class="fa fa-plus"></i></a>' +
        '<a v-show="node.isOpen==null" class="ml5" href="javascript:" title="Edit" v-on:click="Edit(node)" ><i class="fa fa-edit"></i></a>' +
        '<a v-show="node.isOpen==null" class="ml5" href="javascript:" title="Delete" v-on:click="Delete(node)" ><i class="fa fa-trash"></i></a>' +
        '<ul v-show="node.isOpen">' +
        '<li v-show="node.showLoading && node._loading"><i class="fa fa-spinner fa-pulse"></i></li>' +
        '<vue-tree-item v-for="item in node.children" :node="item" v-key="node.id"></vue-tree-item>' +
        '</ul>' +
        '</li>',
        props: {
            node: {
                type: Object
            }
        },
        methods: {
            showIcon: function (node) {
                return node.icon || node.openedIcon || node.closedIcon;
            },
            nodeClass: function (node) {
                if (node.isOpen) {
                    return node.openedIcon || node.icon;
                } else {
                    return node.closedIcon || node.icon;
                }
            },
            toggle: function (node) {
                if (node.hasOwnProperty('isOpen')) {
                    node.isOpen = !node.isOpen;
                } else {
                    Vue.set(node, 'isOpen', true);
                }
            },
            btnClick: function (btn, node) {
                if (typeof btn.click === 'function') {
                    btn.click(node);
                }
            },
            Add: function (node) {
            	Bus.$emit('Add', node);
             },
            Edit: function (node) {
            	Bus.$emit('Edit', node);
            },
            Delete: function (node) {
            	Bus.$emit('Delete', node);
            }
        },
        watch: {
            'node.isOpen': function (val) {
                if (!this.node.hasOwnProperty('_loading')) {
                    Vue.set(this.node, '_loading', false);
                }
                if (val) {
                    if (typeof this.node.onOpened === 'function') {
                        this.node.onOpened(this.node);
                    }
                } else {
                    if (typeof this.node.onClosed === 'function') {
                        this.node.onClosed(this.node);
                    }
                }
            }
        }
    });
    Vue.component('vue-tree-item', VueTreeItem);

    var VueTree = Vue.extend({
        template: '<div class="vue-tree"><ul>' +
        '<tree-item :node.sync="option.root"></tree-item>' +
        '</ul></div>',
        props: {
            option: {
                type: Object
            }
        },
        components: {
            'tree-item': VueTreeItem
        },
        mounted:function() {
        	Bus.$on('Add', content => {
        		data={id:content.id,type:'add'}
        	    this.$emit('btn-click', data)
        	  //  this.$off();
        	});
        	Bus.$on('Edit', content => {
        		data={class_name:content.class_name,id:content.id,type:'edit'}
        	    this.$emit('btn-click', data)
        	});
        	Bus.$on('Delete', content => {
        		data={id:content.id,type:'delete'}
        	    this.$emit('btn-click', data)
        	});
        	
        },
        created: function(){
        	Bus.$off();
        }
    });
   // Vue.component('vue-tree', VueTree);
    Vue.VueTree = VueTree;
})();