import axiosIns from "../../../../plugins/axios"

export const useHoaDonNguoiDung = {
    actions: {
        async layHoaDon(payload) {
            const response = await axiosIns.get(`/api/nguoi_dung/layhoadon?nguoiDungId=${payload.nguoiDungId}&type=${payload.type}`)
            return response
        },
    },
}
