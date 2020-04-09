export const docexchange =[
    {
        meta: {
            requireAuth: true,
            permit: 1
        },
        path: '/docexchange/docTransfer',
        name: '传递单',
        component: () => import('@/views/docexchange/DocTransfer.vue')
    },
    {
        meta: {
            requireAuth: true,
            permit: 1
        },
        path: '/docexchange/shoppingCart',
        name: '购物车',
        component: () => import('@/components/ShoppingCart.vue')
    },
    {
        meta: {
            requireAuth: true,
            permit: 1
        },
        path: '/docexchange/ChoiceType',
        name: '类型选择',
        component: () => import('@/views/docexchange/ChoiceType.vue')
    },
    {
        meta: {
            requireAuth: true,
            permit: 1
        },
        path: '/docexchange/CreateDoc',
        name: '创建文件',
        component: () => import('@/components/Properties.vue')
    }
]
